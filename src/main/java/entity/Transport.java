package entity;

public class Transport {
    private int transportId;
    private String transportName;
    private int priceTransPort;
    private String descriptionTransport;

    public Transport() {
    }

    public Transport(int transportId, String transportName, int priceTransPort, String descriptionTransport) {
        this.transportId = transportId;
        this.transportName = transportName;
        this.priceTransPort = priceTransPort;
        this.descriptionTransport = descriptionTransport;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public int getPriceTransPort() {
        return priceTransPort;
    }

    public void setPriceTransPort(int priceTransPort) {
        this.priceTransPort = priceTransPort;
    }

    public String getDescriptionTransport() {
        return descriptionTransport;
    }

    public void setDescriptionTransport(String descriptionTransport) {
        this.descriptionTransport = descriptionTransport;
    }
}
