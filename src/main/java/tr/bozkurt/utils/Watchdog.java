package tr.bozkurt.utils;

import tr.bozkurt.Server;

import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;

public class Watchdog extends Thread{

	private final Server server;
	private final long time;
	public boolean running = true;
	private boolean responding = true;

	public Watchdog(Server server, long time){
		this.server = server;
		this.time = time;
		this.running = true;
	}

	private static void dumpThread(ThreadInfo thread, Logger logger){
		logger.emergency("Current Thread: " + thread.getThreadName());
		logger.emergency("\tPID: " + thread.getThreadId() + " | Suspended: " + thread.isSuspended() + " | Native: " + thread.isInNative() + " | State: " + thread.getThreadState());
		// Monitors
		if(thread.getLockedMonitors().length != 0){
			logger.emergency("\tThread is waiting on monitor(s):");
			for(MonitorInfo monitor : thread.getLockedMonitors()){
				logger.emergency("\t\tLocked on:" + monitor.getLockedStackFrame());
			}
		}

		logger.emergency("\tStack:");
		for(StackTraceElement stack : thread.getStackTrace()){
			logger.emergency("\t\t" + stack);
		}
	}

	public void kill(){
		running = false;
		synchronized(this){
			this.notifyAll();
		}
	}

	@Override
	public void run(){
		while(this.running && server.isRunning()){
			long current = server.getNextTick();
			if(current != 0){
				long diff = System.currentTimeMillis() - current;
				if(diff > time){
					if(responding){
						MainLogger logger = this.server.getLogger();
						logger.emergency("--------- Server stopped responding --------- (" + (diff / 1000d) + "s)");
						logger.emergency("Please report this to bozkurt:");
						logger.emergency(" - https://github.com/BozkurtX/Bozkurt/issues/new");
						logger.emergency("---------------- Main thread ----------------");

						dumpThread(ManagementFactory.getThreadMXBean().getThreadInfo(this.server.getPrimaryThread().getId(), Integer.MAX_VALUE), logger);

						logger.emergency("---------------- All threads ----------------");
						ThreadInfo[] threads = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
						for(int i = 0; i < threads.length; i++){
							if(i != 0) logger.emergency("------------------------------");
							dumpThread(threads[i], logger);
						}
						logger.emergency("---------------------------------------------");
						responding = false;
					}
				}else{
					responding = true;
				}
			}
			try{
				synchronized(this){
					this.wait(Math.max(time / 4, 1000));
				}
			}catch(InterruptedException ignore){
			}
		}
	}

}