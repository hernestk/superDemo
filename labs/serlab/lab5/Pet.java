// SER120L - Lab 5
// Hernest Koroli

public interface Pet {
    public String getName();
    public boolean isAdopted();
    public void setIsAdopted(boolean newAdoptionStatus);
    public String getOwnerName();
    public void setOwnerName(String newOwnerName);
    public void printAboutMe();
}