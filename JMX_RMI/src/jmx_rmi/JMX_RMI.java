/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmx_rmi;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 *
 * @author Luiz Henrque Buris
 */
public class JMX_RMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://notenook02:8686/jndi/rmi://notenook02:8686/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();

        MemoryMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(mbsc, ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
        System.out.println(mbean.getHeapMemoryUsage());
        System.out.println(mbean.getNonHeapMemoryUsage());

        // ObjectName mbeanName = new ObjectName("com.jmx:type=alerta");
        // AlertasVigentesBean alert = JMX.newMBeanProxy(mbsc, mbeanName, AlertasVigentesBean.class, true);
        // System.out.println(alert.getAlertaListAll());
    }

}
