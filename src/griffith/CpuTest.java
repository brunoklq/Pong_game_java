package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class CpuTest {



	    @Test
	    public void testControlToggle() {
	        Cpu cpu = new Cpu(950, 200, 25, 100, 2);

	        cpu.enableControl();
	        assertTrue(cpu.isControllable());

	        cpu.disableControl();
	        assertFalse(cpu.isControllable());
	    }

	    @Test
	    public void testMoveWithinBounds() {
	        Cpu cpu = new Cpu(950, 0, 25, 100, 2);
	        cpu.setYDirection(20);
	        cpu.move();

	        // It should move down by 20
	        assertEquals(20, cpu.y);
	    }

	    @Test
	    public void testAutoMoveDownward() throws InterruptedException {
	        Cpu cpu = new Cpu(950, 100, 25, 100, 2);
	        cpu.disableControl(); // Required to allow autoMove

	        // Create a dummy ball below the cpu
	        Ball dummyBall = new Ball(500, 400, 20, 20); 

	        // Simulate time delay
	        Thread.sleep(20);

	        cpu.autoMove(dummyBall);
	        assertTrue(cpu.y > 100); // CPU should move downward
	    }

	    @Test
	    public void testAutoMoveUpward() throws InterruptedException {
	        Cpu cpu = new Cpu(950, 400, 25, 100, 2);
	        cpu.disableControl();

	        // Create a dummy ball above the cpu
	        Ball dummyBall = new Ball(500, 100, 20, 20); 

	        Thread.sleep(20);

	        cpu.autoMove(dummyBall);
	        assertTrue(cpu.y < 400); // CPU should move upward
	    }
}
