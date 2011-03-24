package ro.cuzma.larry.persistance.xml.samples.sample2.objectxmlconnection;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.XMLNode;
import ro.cuzma.larry.persistance.xml.exception.XMLException;
import ro.cuzma.larry.persistance.xml.samples.sample2.objects.CalibreBook;

public class PackageHelper extends XMLNode {

    private CalibreBookHelper calibreBookHelper;

    public PackageHelper() {
        super(XMLTags.PACKAGE);
    }

    public PackageHelper(CalibreBook bk) throws XMLException {
        super(XMLTags.PACKAGE, bk);
    }

    @Override
    protected void initTags() {
        addAtribute("xmlns", "http://www.idpf.org/2007/opf");
        addAtribute("unique-identifier", "uuid_id");
        calibreBookHelper = new CalibreBookHelper();
        xmlObjects.add(calibreBookHelper);

    }

    @Override
    protected void initWithEntity(Entity<?> entity) throws XMLException {
        // CalibreBook calBook = (CalibreBook) entity;
        xmlObjects.remove(calibreBookHelper);
        calibreBookHelper = new CalibreBookHelper((CalibreBook) entity);
        xmlObjects.add(calibreBookHelper);

    }

}
