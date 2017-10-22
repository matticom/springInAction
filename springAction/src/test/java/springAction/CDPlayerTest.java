package springAction;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CDPlayerConfig;
import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;
import soundsystem.SgtPeppers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	@Autowired
	private MediaPlayer player;

	@Autowired
	private CompactDisc cd;

	@Autowired
	private SgtPeppers sgtPeppers;

	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}

	@Test
	public void sgtPeppersShouldNotBeNull() {
		assertNotNull(sgtPeppers);
	}

	@Test
	public void play() {
		player.play();
		assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n", log.getLog());
	}
}
