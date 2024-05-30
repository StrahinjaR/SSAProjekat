package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "file_entity")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public File(Long id, String fileName, String fileType, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public File() {
    }
}
