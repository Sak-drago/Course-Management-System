public class Complaints {
    int Complaint_Code;
    String Complaint;
    boolean status;
    String show_status;
    public Complaints(int Complaint_Code,String complaint){
        this.Complaint_Code = Complaint_Code;
        this.Complaint = complaint;
        this.status = false;
        if(this.status == false){
            this.show_status = "Pending";
        }
        else {
            this.show_status = "Resolved";
        }
    }
}
