/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.claseAuxiliares;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Luis Felipe Cantero
 */
public class reporteFactura {

    public void getReporte(String ruta, Integer codC, Integer codV, Integer codF) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection conexion = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FACTURACION;encrypt=true;trustServerCertificate=true", "sa", "Luis12345.");

        //Se definen los parametros si es que el reporte necesita
        Map parameter = new HashMap();
        parameter.put("CODCLIENTE", codC);
        parameter.put("CODVENDEDOR", codV);
        parameter.put("CODFACTURA", codF);

        try {
            File file = new File(ruta);
            System.out.println("Ruta del archivo: " + file.getPath());
            System.out.println("Archivo existe: " + file.exists());

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-Type", "application/pdf");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            System.out.println("Reporte cargado correctamente.");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);
            System.out.println("Reporte llenado correctamente.");

            JRExporter jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            jrExporter.exportReport();
            FacesContext.getCurrentInstance().responseComplete();
            System.out.println("Reporte exportado correctamente.");

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null && !conexion.isClosed()) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
