package tr.bozkurt.event;

/**
 * Created by Bozkurt Team.
 */
public interface Cancellable{

	boolean isCancelled();

	void setCancelled(boolean forceCancel);

	void setCancelled();

}
