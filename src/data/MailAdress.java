/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Marc
 */
final public class MailAdress {
    private final String mail;
    public MailAdress(String mail) throws Exception { 
        if(mail == null){
           throw new Exception("MailAdress invalid");
        } 
        this.mail = mail; 
    }
    public String getMail() { return mail; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAdress mail1 = (MailAdress) o;
        return mail.equals(mail1.mail);
    }
 
    @Override
    public int hashCode() { return mail.hashCode(); }
 
    @Override
    public String toString() {
       return "MailAdress='" + mail + '\'' + '}';
    }   
}
