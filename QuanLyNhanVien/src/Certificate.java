import java.sql.Date;

public class Certificate {
    private int certificatedId;
    private String certificateName;
    private String certificateRank;
    private Date certificatedDate;

    public Certificate(int certificatedId, String certificateName, String certificateRank, Date certificatedDate) {
        this.certificatedId = certificatedId;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    public int getCertificatedId() {
        return certificatedId;
    }

    public void setCertificatedId(int certificatedId) {
        this.certificatedId = certificatedId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public Date getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(Date certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return certificatedId + certificateName + certificateRank + certificatedDate;
    }
}
