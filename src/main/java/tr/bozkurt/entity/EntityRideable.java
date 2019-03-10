package tr.bozkurt.entity;

/**
 * Bozkurt Project
 */
public interface EntityRideable{

	/**
	 * Mount or Dismounts an Entity from a rideable entity
	 *
	 * @param entity The target Entity
	 * @return {@code true} if the mounting successful
	 */
	boolean mountEntity(Entity entity);

}
