package sem2015.gr19.html;

import sem2015.gr19.core.sem2015;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class sem2015Html extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new sem2015();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
