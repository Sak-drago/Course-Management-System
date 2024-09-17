public class Complaints {
    String person;
    int Complaint_Code;
    String Complaint;
    boolean status;
    String show_status;
    public Complaints(int Complaint_Code,String complaint, String person){
        this.person = person;
        this.Complaint_Code = Complaint_Code;
        this.Complaint = complaint;
        this.status = false;
        if(!this.status){
            this.show_status = "Pending";
        }
        else {
            this.show_status = "Resolved";
        }
    }

    public int getComplaintCode() {
        return Complaint_Code;
    }

    public String getComplaint() {
        return Complaint;
    }

    public String getShowStatus() {
        return show_status;
    }

    public void setShowStatus(String showStatus) {
        this.show_status = showStatus;

    }
}
