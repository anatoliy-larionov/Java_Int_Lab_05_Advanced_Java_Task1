package hotel;

public class Hotel {
    private int id;
    private String nameHotel;

    public Hotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    @Override
    public String toString() {
        return "id = " + getId() +
                ", hotel = " + getNameHotel();
    }
}
