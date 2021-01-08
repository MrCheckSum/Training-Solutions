package immutable.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceAgencyTest {

    @Test
    public void testRegisterSatellite() {
        //Given
        SpaceAgency spaceAgency= new SpaceAgency();
        //When
        spaceAgency.registerSatellite(new Satellite(new CelestialCoordinates(1,2,3),"AB1"));
        spaceAgency.registerSatellite(new Satellite(new CelestialCoordinates(10,20,30),"AB2"));
        //Then
        assertEquals("[AB1: CelestialCoordinates > x:1, y:2, z:3, AB2: CelestialCoordinates > x:10, y:20, z:30]",spaceAgency.toString());
    }

    @Test
    public void testFindSatellitebyRegisterIdent() {
        //Given
        SpaceAgency spaceAgency = new SpaceAgency();
        //When
        spaceAgency.registerSatellite(new Satellite(new CelestialCoordinates(20,40,60),"AB0001"));
        spaceAgency.registerSatellite(new Satellite(new CelestialCoordinates(30,60,90),"AB0002"));
        //Then
        assertEquals("AB0001: CelestialCoordinates > x:20, y:40, z:60", spaceAgency.findSatellitebyRegisterIdent("AB0001").toString());
    }

    @Test
    public void testNotFoundSatelleiteByRegisterIdent() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new SpaceAgency().findSatellitebyRegisterIdent("BB0001"));
        assertEquals("Satellite is not found with BB0001", exception.getMessage());
    }

    @Test
    public void testNullParameterShouldThrowExpectationAtRegisterSatellite() throws NullPointerException{
        Exception exception= assertThrows(NullPointerException.class, ()-> new SpaceAgency().registerSatellite(null));
        assertEquals("Satellite is empty!",exception.getMessage());
    }
}