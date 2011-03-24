package ro.cuzma.larry.persistance.xml.samples.sample2;

import ro.cuzma.larry.persistance.xml.XMLUtil;
import ro.cuzma.larry.persistance.xml.exception.XMLException;
import ro.cuzma.larry.persistance.xml.samples.sample2.objects.CalibreBook;
import ro.cuzma.larry.persistance.xml.samples.sample2.objectxmlconnection.PackageHelper;

public class Sample2 {

    public static void main(String[] args) throws XMLException {

        // now open file and read objects from it
        // XMLFileManipulation ll = new XMLFileManipulation();
        // PackageHelper lh = (PackageHelper) ll.loadFromFile(new File("e://metadata.opf"),
        // new XMLFactoryLibrary());
        // System.out.println(lh.toXml(""));

        CalibreBook bk = new CalibreBook();
        bk.setTitle("Title");
        bk.addCreator("Larry Autor");
        bk.addCreator("Larry Autor2");
        bk.setPublisher("Nemira");
        bk.setDate("2003-04-12");
        bk.setIsbn("112312313");
        bk.setRating("8");
        bk.setLanguage("romana");
        bk.setSeries("Seria lui larry");
        bk.setToRead("true");
        bk.setColnr(new Long("5"));
        bk.setPrice(new Double("15.34"));
        bk.setCollection("Nautilius");
        bk.setType("SF");
        bk.setReadNr(new Long("2"));
        bk.setLanguage("romana");
        bk.setCurrency("ROL");
        PackageHelper bh = new PackageHelper(bk);

        XMLUtil.fileToZIP(XMLUtil.saveXMLToFile("e://test.opf", bh), "e://test.zip");
        // System.out.println(bh.toXml(""));

    }
}
