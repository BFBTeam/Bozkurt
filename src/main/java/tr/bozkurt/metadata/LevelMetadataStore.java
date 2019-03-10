package tr.bozkurt.metadata;

import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public class LevelMetadataStore extends MetadataStore{

	@Override
	protected String disambiguate(Metadatable level, String metadataKey){
		if(!(level instanceof Level)){
			throw new IllegalArgumentException("Argument must be a Level instance");
		}
		return (((Level) level).getName() + ":" + metadataKey).toLowerCase();
	}

}
