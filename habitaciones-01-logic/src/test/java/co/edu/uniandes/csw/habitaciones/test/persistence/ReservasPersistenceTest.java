/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.habitaciones.test.persistence;

import co.edu.uniandes.csw.habitaciones.entities.ReservaEntity;
import co.edu.uniandes.csw.habitaciones.persistence.ReservaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class ReservasPersistenceTest {
    
    public static final String DEPLOY = "PruebaReservaPersistence";
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
        /**
     * @generated
     */
    @Inject
    private ReservaPersistence reservaPersistence;

    /**
     * @generated
     */
    @PersistenceContext(unitName = "habitacionesPU")
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Vivienda.
     *
     * @generated
     */
    @Test
    public void createReservaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
        ReservaEntity result = reservaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ReservaEntity entity = em.find(ReservaEntity.class, result.getCodigoReserva());
        double error = 0.00000001;

        Assert.assertEquals(newEntity.getCosto(), entity.getCosto(), error);
        Assert.assertEquals(newEntity.getEstado(),entity.getEstado());
        Assert.assertEquals(newEntity.getFechaInicio(), entity.getFechaInicio());
        Assert.assertEquals(newEntity.getFechaFin(), entity.getFechaFin());
        Assert.assertEquals(newEntity.getHabitacion(), entity.getHabitacion());
        Assert.assertEquals(newEntity.getMulta(), entity.getMulta());
        Assert.assertEquals(newEntity.getVivienda(), entity.getVivienda());
    }

    /**
     * Prueba para consultar la lista de Books.
     *
     * @generated
     */
    @Test
    public void getReservasTest() {
        List<ReservaEntity> list = reservaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) {
            boolean found = false;
            for (ReservaEntity entity : data) {
                if (ent.getCodigoReserva().equals(entity.getCodigoReserva())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Book.
     *
     * @generated
     */
    @Test
    public void getReservaTest() {
        ReservaEntity entity = data.get(0);
        ReservaEntity newEntity = reservaPersistence.find(entity.getCodigoReserva());
        double error = 0.00000001;
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getCosto(), entity.getCosto(), error);
        Assert.assertEquals(newEntity.getEstado(),entity.getEstado());
        Assert.assertEquals(newEntity.getFechaInicio(), entity.getFechaInicio());
        Assert.assertEquals(newEntity.getFechaFin(), entity.getFechaFin());
        Assert.assertEquals(newEntity.getHabitacion(), entity.getHabitacion());
        Assert.assertEquals(newEntity.getMulta(), entity.getMulta());
        Assert.assertEquals(newEntity.getVivienda(), entity.getVivienda());
    }
    /**
     * Prueba para actualizar un Book.
     *
     * @generated
     */
    @Test
    public void updateReservaTest() {
        ReservaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
        newEntity.setCodigoReserva(entity.getCodigoReserva());
        double error = 0.00000001;

        reservaPersistence.update(newEntity);

        ReservaEntity resp = em.find(ReservaEntity.class, entity.getCodigoReserva());
        
        Assert.assertEquals(newEntity.getCosto(), resp.getCosto(), error);
        Assert.assertEquals(newEntity.getEstado(),resp.getEstado());
        Assert.assertEquals(newEntity.getFechaInicio(), resp.getFechaInicio());
        Assert.assertEquals(newEntity.getFechaFin(), resp.getFechaFin());
        Assert.assertEquals(newEntity.getHabitacion(), resp.getHabitacion());
        Assert.assertEquals(newEntity.getMulta(), resp.getMulta());
        Assert.assertEquals(newEntity.getVivienda(), resp.getVivienda());
    }
    
}
