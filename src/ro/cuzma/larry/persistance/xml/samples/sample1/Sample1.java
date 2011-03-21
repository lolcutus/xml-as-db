package ro.cuzma.larry.persistance.xml.samples.sample1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ro.cuzma.larry.persistance.xml.XMLFileManipulation;
import ro.cuzma.larry.persistance.xml.exception.XMLException;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.Author;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.EntityFactory;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.Library;
import ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection.LibraryHelper;
import ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection.XMLFactoryLibrary;

public class Sample1 {

    public static void main(String[] args) throws XMLException {

        // Create a library obkect which contain authors objects
        Author author = new Author(new Long(1), "first", "middle", "name");
        Author author2 = new Author(new Long(2), "first2", "middle2", "name2");

        Library lib = new Library("mylib", "c:/test");
        lib.addAuthor(author);
        lib.addAuthor(author2);

        // get xml String from previosly created objects
        LibraryHelper libh = new LibraryHelper(lib);
        System.out.println(libh.toXml(""));

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("lib.xml"));
            out.write(libh.toXml(""));
            out.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // now open file and read objects from it
        XMLFileManipulation ll = new XMLFileManipulation();
        LibraryHelper lh = (LibraryHelper) ll.loadFromFile(new File("lib.xml"),
                new XMLFactoryLibrary());

        try {
            Library openone = EntityFactory.buildLibrary(lh);
            LibraryHelper lib2 = new LibraryHelper(openone);
            System.out.println(lib2.toXml(""));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
