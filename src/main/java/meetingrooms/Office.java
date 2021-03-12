package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNamesInOrder() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNameReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printRoomArea() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName() + ":" + meetingRoom.getRoomArea());
        }
    }

    public void printMeetingRoomsContains(String partName) {
        partName = partName.toLowerCase();
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().contains(partName)) {
                System.out.println("Name:" + meetingRoom.getName() + " Length:" + meetingRoom.getLength() + " Width:" + meetingRoom.getWidth() + " Area:" + meetingRoom.getRoomArea() + "\n");
            }
        }
    }

    public void printAreaLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getRoomArea() > area) {
                System.out.println(meetingRoom.getName());
            }
        }
    }
}