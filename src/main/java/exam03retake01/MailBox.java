package exam03retake01;


import xtest.A;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {

        if (criteria.startsWith("to:")) {
            return findByTo(criteria.substring(3));
        } else if (criteria.startsWith("from:")) {
            return findByFrom(criteria.substring(5));
        } else {
            return findByContent(criteria);
        }
    }


    private List<Mail> findByTo(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            for (Contact contact : mail.getTo()) {
                if (contact.getName().equals(substring) || contact.getEmail().equals(substring)) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> findByFrom(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFrom().getName().equals(substring) || mail.getFrom().getEmail().equals(substring)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByContent(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getMessage().contains(criteria) || mail.getSubject().contains(criteria)) {
                result.add(mail);
            }
        } return result;
    }
}
