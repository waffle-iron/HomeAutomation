package cm.homeautomation.entities.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;

import cm.homeautomation.db.EntityManagerService;
import cm.homeautomation.entities.Room;
import cm.homeautomation.entities.Sensor;

public class SensorTest {
	private EntityManager em;
	private Room room;
	

	@Before
	public void setup() {
		em = EntityManagerService.getNewManager();
		
		room = new Room();
		room.setRoomName("Test Sensor Room");

		em.persist(room);
	}
	
	@Test
	public void testCreateSensor() throws Exception {
		Sensor sensor = new Sensor();
		sensor.setRoom(room);
		sensor.setSensorName("Testsensor");
		
		em.persist(sensor);

		assertTrue("Id: "+sensor.getId(), sensor.getId()!=null);
	}

	@Test(expected=PersistenceException.class)
	public void testCreateEmptySensor() throws Exception {
		Sensor sensor = new Sensor();
		sensor.setRoom(room);
		em.persist(sensor);
		assertTrue("Id: "+sensor.getId(), sensor.getId()==null);
	}
}