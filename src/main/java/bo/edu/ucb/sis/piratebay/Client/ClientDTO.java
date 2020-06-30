package bo.edu.ucb.sis.piratebay.Client;

import java.sql.Date;

public class ClientDTO {

    private Integer clientId, txId, txUserId;
    private String firstName, lastName, txHost;
    private Date birthDate, txDate;
    private Boolean status;

    public ClientDTO(Integer clientId, Integer txId, Integer txUserId, String firstName, String lastName, String txHost, Date birthDate, Date txDate, Boolean status) {
        this.clientId = clientId;
        this.txId = txId;
        this.txUserId = txUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.txHost = txHost;
        this.birthDate = birthDate;
        this.txDate = txDate;
        this.status = status;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public Integer getTxUserId() {
        return txUserId;
    }

    public void setTxUserId(Integer txUserId) {
        this.txUserId = txUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "clientId," +
                        "txId," +
                        "txUserId," +
                        "firstName," +
                        "lastName," +
                        "txHost," +
                        "birthDate," +
                        "txDate," +
                        "status"
                ;
    }
}
