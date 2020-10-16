package io.com.github.mrspock182.magalu;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class TestSetup {

	@BeforeAll
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("io.com.github.mrspock182.magalu");
	}

	@Before
	public abstract void init();
}