package Eco3DPrint.BackendEco3DPrint.model;
import jakarta.persistence.*;


@Entity
@Table(name = "archive")
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private byte[] file_data;

    /*
    public Archive(String name, byte[] file_data){
        this.name = name;
        this.file_data = file_data;
    }
    */

    public void setFileData(byte[] fileData) {
        this.file_data = fileData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFileData() {
        return file_data;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
