package aero.nettracer.persistence.model;

/**
 * Created by wyan on 2/8/2017.
 */
public class LFReturnRate {

    private String val;
    private String week;
    private int entered;
    private int enteredAtLFC;
    private int enteredAtOtherStations;
    private int returnedAtLFC;
    private int waitingOnCustomer;
    private int returnedAtOtherStations;
    private int holdForPickup;
    private int deliveredToCustomer;
    private int deliveryRejected;
    private int totalReturns;
    private int totalReturnsAtLFC;
    private int totalReturnsAtOtherStations;
    private double returnRate;
    private double lfcReturnRate;
    private double otherStationReturnRate;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getEntered() {
        return entered;
    }

    public void setEntered(int entered) {
        this.entered = entered;
    }

    public int getEnteredAtLFC() {
        return enteredAtLFC;
    }

    public void setEnteredAtLFC(int enteredAtLFC) {
        this.enteredAtLFC = enteredAtLFC;
    }

    public int getReturnedAtLFC() {
        return returnedAtLFC;
    }

    public void setReturnedAtLFC(int returnedAtLFC) {
        this.returnedAtLFC = returnedAtLFC;
    }

    public int getReturnedAtOtherStations() {
        return returnedAtOtherStations;
    }

    public void setReturnedAtOtherStations(int returnedAtOtherStations) {
        this.returnedAtOtherStations = returnedAtOtherStations;
    }

    public int getWaitingOnCustomer() {
        return waitingOnCustomer;
    }

    public void setWaitingOnCustomer(int waitingOnCustomer) {
        this.waitingOnCustomer = waitingOnCustomer;
    }

    public int getHoldForPickup() {
        return holdForPickup;
    }

    public void setHoldForPickup(int holdForPickup) {
        this.holdForPickup = holdForPickup;
    }

    public int getDeliveredToCustomer() {
        return deliveredToCustomer;
    }

    public void setDeliveredToCustomer(int deliveredToCustomer) {
        this.deliveredToCustomer = deliveredToCustomer;
    }

    public int getDeliveryRejected() {
        return deliveryRejected;
    }

    public void setDeliveryRejected(int deliveryRejected) {
        this.deliveryRejected = deliveryRejected;
    }

    public int getTotalReturns() {
        return totalReturns;
    }

    public void setTotalReturns(int totalReturns) {
        this.totalReturns = totalReturns;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(double returnRate) {
        this.returnRate = returnRate;
    }

    public double getLfcReturnRate() {
        return lfcReturnRate;
    }

    public void setLfcReturnRate(double lfcReturnRate) {
        this.lfcReturnRate = lfcReturnRate;
    }

    public int getEnteredAtOtherStations() {
        return enteredAtOtherStations;
    }

    public void setEnteredAtOtherStations(int enteredAtOtherStations) {
        this.enteredAtOtherStations = enteredAtOtherStations;
    }

    public int getTotalReturnsAtLFC() {
        return totalReturnsAtLFC;
    }

    public void setTotalReturnsAtLFC(int totalReturnsAtLFC) {
        this.totalReturnsAtLFC = totalReturnsAtLFC;
    }

    public int getTotalReturnsAtOtherStations() {
        return totalReturnsAtOtherStations;
    }

    public void setTotalReturnsAtOtherStations(int totalReturnsAtOtherStations) {
        this.totalReturnsAtOtherStations = totalReturnsAtOtherStations;
    }

    public double getOtherStationReturnRate() {
        return otherStationReturnRate;
    }

    public void setOtherStationReturnRate(double otherStationReturnRate) {
        this.otherStationReturnRate = otherStationReturnRate;
    }
}
