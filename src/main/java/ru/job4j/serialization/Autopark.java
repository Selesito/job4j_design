package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "autopark")
@XmlAccessorType(XmlAccessType.FIELD)
public class Autopark {
    @XmlAttribute
    private  String nameCompany;
    @XmlAttribute
    private  int countCar;
    @XmlElementWrapper(name = "passengers")
    @XmlElement(name = "passenger")
    private  String[] passenger;
    @XmlAttribute
    private  boolean close;
    @XmlElement(name = "bus")
    private  Bus bus;

    public Autopark() {
    }

    public Autopark(String nameCompany, int countCar, String[] passenger, boolean close, Bus bus) {
        this.nameCompany = nameCompany;
        this.countCar = countCar;
        this.passenger = passenger;
        this.close = close;
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Autopark{"
                + "nameCompany='" + nameCompany + '\''
                + ", countCar=" + countCar
                + ", passenger=" + Arrays.toString(passenger)
                + ", close=" + close
                + ", bus=" + bus + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Autopark auto = new Autopark("Moroz", 30,
                new String[] {"Петров", "Федоров"}, true, new Bus("ПАЗ"));

        JAXBContext context = JAXBContext.newInstance(Autopark.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(auto, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
