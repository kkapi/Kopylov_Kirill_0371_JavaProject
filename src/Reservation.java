public class Reservation {

    private int reservationId;
    private int clientId;
    private int[] equipmentId;
    private String date;
    private String time;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int[] getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int[] equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
