package co.uco.bitacora.service.recomendacion;

import co.uco.bitacora.domain.recomendacion.Recomendacion;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.rabbitMQ.Suscription;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecomendacionService {
    @Autowired
    private Publicador publicador;

    @Autowired
    private Suscription suscripcion1;


    private  String data;

    @Transactional
    public  List<Recomendacion> CargarRecomendaciones(long id ){
        List<Recomendacion> recomendaciones = new ArrayList<>();
        try {

            switch ((int)id){
                case 1:
                    // portatil
                    data="Evita cargar la batería constantemente al 100%, ya que puede reducir su vida útil. Intenta mantenerla entre el 20% y el 80% de carga para prolongar su duración.";
                    recomendaciones.add(new Recomendacion(1,data,1));

                    data="Ajusta el brillo de la pantalla según las condiciones de iluminación para reducir el consumo de energía y prolongar la vida útil de la pantalla.";
                    recomendaciones.add(new Recomendacion(2,data,2));

                    data="Realiza actualizaciones regulares del sistema operativo para mantenerlo seguro y obtener las últimas características y mejoras de rendimiento.";
                    recomendaciones.add(new Recomendacion(3,data,3));

                    data="Verifica regularmente si hay actualizaciones de controladores disponibles para tu hardware y aplicarlas para garantizar un rendimiento óptimo y la compatibilidad del sistema.";
                    recomendaciones.add(new Recomendacion(4,data,4));

                    data="Desinstala programas y aplicaciones que no uses para liberar espacio en el disco duro y mejorar el rendimiento general del sistema.";
                    recomendaciones.add(new Recomendacion(5,data,5));

                    data="Instala y actualiza regularmente un software antivirus confiable para proteger tu sistema contra virus, malware y otras amenazas de seguridad en línea.";
                    recomendaciones.add(new Recomendacion(6,data,6));

                    data="Realiza pruebas de rendimiento periódicas para evaluar el rendimiento de tu sistema y detectar posibles problemas de hardware o cuellos de botella.";
                    recomendaciones.add(new Recomendacion(7,data,7));

                    data="Mantén un ojo en la temperatura del sistema y asegúrate de que no supere los niveles seguros durante el uso intensivo para evitar el sobrecalentamiento.";
                    recomendaciones.add(new Recomendacion(8,data,8));

                    data="Mantén limpias las lentes de las cámaras y los sensores para obtener imágenes nítidas y un rendimiento óptimo del sistema de detección.";
                    recomendaciones.add(new Recomendacion(9,data,9));

                    data="Limpia regularmente el teclado y el touchpad para evitar la acumulación de suciedad y mantener un funcionamiento suave y preciso.";
                    recomendaciones.add(new Recomendacion(10,data,10));

                    data="Verifica regularmente todas las conexiones externas, como cables y puertos, para asegurarte de que estén en buen estado y funcionen correctamente.";
                    recomendaciones.add(new Recomendacion(11,data,11));

                    break;
                    case 2:
                        // mesa

                        data="Verifica que la cantidad de RAM instalada sea suficiente para ejecutar tus aplicaciones y tareas diarias sin problemas de rendimiento.";
                        recomendaciones.add(new Recomendacion(12,data,12));

                        data="Considera actualizar a un SSD si aún estás utilizando un disco duro tradicional, para mejorar significativamente el rendimiento y la velocidad de tu sistema.";
                        recomendaciones.add(new Recomendacion(13,data,13));

                        data="Comprueba que la GPU sea compatible con tus necesidades de trabajo o entretenimiento, especialmente si planeas ejecutar aplicaciones o juegos exigentes.";
                        recomendaciones.add(new Recomendacion(14,data,14));

                        data="Instalar ventiladores adicionales si es necesario para mantener una temperatura óptima en tu sistema y evitar el sobrecalentamiento de los componentes.";
                        recomendaciones.add(new Recomendacion(15,data,15));

                        data="Elige un monitor de alta calidad con una buena resolución y frecuencia de actualización para una experiencia visual óptima.";
                        recomendaciones.add(new Recomendacion(16,data,16));

                        data="Mantén tu sistema operativo actualizado para aprovechar las últimas características de seguridad y rendimiento.";
                        recomendaciones.add(new Recomendacion(17,data,17));

                        data="Actualiza regularmente los controladores de tus dispositivos para garantizar la compatibilidad y el rendimiento óptimo del hardware.";
                        recomendaciones.add(new Recomendacion(18,data,18));

                        data="Utiliza puertos USB de alta velocidad para dispositivos que requieran transferencias de datos rápidas, como unidades flash o discos duros externos.";
                        recomendaciones.add(new Recomendacion(19,data,19));

                        data="Realiza pruebas de rendimiento periódicas para evaluar el rendimiento de tu sistema y detectar posibles cuellos de botella o problemas de hardware.";
                        recomendaciones.add(new Recomendacion(20,data,20));

                        data="Mantén un ojo en la temperatura de tu sistema y asegúrate de que no supere los niveles seguros durante el uso intensivo.";
                        recomendaciones.add(new Recomendacion(21,data,21));

                        data="Mantén actualizados el software y los controladores de tu equipo para beneficiarte de las últimas características, correcciones de errores y mejoras de seguridad.";
                        recomendaciones.add(new Recomendacion(22,data,22));


                        break;
                        case 3:

                            //celular

                            data= "Mantén el teléfono en una funda protectora y utiliza protectores de pantalla para evitar daños.";
                            recomendaciones.add(new Recomendacion(23,data,23));

                            data="Limpia regularmente la carcasa del teléfono con un paño suave y seco para eliminar el polvo y la suciedad.";
                            recomendaciones.add(new Recomendacion(24,data,23));

                            data="Evita exponer la pantalla a objetos afilados o a altas temperaturas para prevenir rayones y daños.";
                            recomendaciones.add(new Recomendacion(25,data,24));

                            data="Limpia la pantalla con un paño suave y sin pelusa para mantenerla libre de manchas y huellas dactilares.";
                            recomendaciones.add(new Recomendacion(26,data,24));

                            data="Evita presionar los botones con fuerza excesiva para evitar daños en los mecanismos internos.";
                            recomendaciones.add(new Recomendacion(27,data,25));

                            data="Limpia los puertos de carga y auriculares regularmente para eliminar el polvo y los residuos que puedan afectar la conectividad.";
                            recomendaciones.add(new Recomendacion(28,data,25));

                            data="Mantén las lentes de las cámaras limpias y sin rayones para obtener imágenes nítidas y claras.";
                            recomendaciones.add(new Recomendacion(29,data,26));

                            data="Evita exponer las cámaras a condiciones extremas de temperatura o humedad que puedan afectar su funcionamiento.";
                            recomendaciones.add(new Recomendacion(30,data,26));

                            data="Limpia los altavoces y el micrófono con aire comprimido o un cepillo suave para eliminar la suciedad y los residuos que puedan afectar la calidad del sonido.";
                            recomendaciones.add(new Recomendacion(31,data,27));

                            data="Evita exponer los altavoces y el micrófono a líquidos que puedan causar daños permanentes.";
                            recomendaciones.add(new Recomendacion(32,data,27));

                            data="Verifica regularmente el funcionamiento de los sensores y las funciones especiales del teléfono para asegurarte de que estén activos y funcionando correctamente.";
                            recomendaciones.add(new Recomendacion(33,data,28));

                            data="Si encuentras algún problema con los sensores o funciones especiales, reinicia el teléfono o consulta el servicio técnico para obtener ayuda.";
                            recomendaciones.add(new Recomendacion(34,data,28));

                            data="Evita exponer el teléfono a temperaturas extremadamente altas o bajas, ya que esto puede afectar la vida útil de la batería.";
                            recomendaciones.add(new Recomendacion(35,data,29));

                            data="Si notas que la batería se descarga más rápido de lo normal o se hincha, es posible que necesite ser reemplazada por una nueva.";
                            recomendaciones.add(new Recomendacion(36,data,29));

                            data="Mantén el sistema operativo y las aplicaciones del teléfono actualizadas para garantizar un rendimiento óptimo y la seguridad.";
                            recomendaciones.add(new Recomendacion(37,data,30));

                            data="Realiza regularmente copias de seguridad de tus datos importantes para evitar la pérdida de información en caso de problemas con el software.";
                            recomendaciones.add(new Recomendacion(38,data,30));


                            break;
                default:
                    data="No hay Recomendaciones";
                    recomendaciones.add(new Recomendacion(39,data,31));
                    break;
            }
          return recomendaciones;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }




    // este metodo es para optener las recomendaciones de cada chek
    @Transactional
    public  List<Recomendacion> listarRecomendacionesPorIDChek(long id){
        List<Recomendacion> respuesta=new ArrayList<>();
        List<Recomendacion> recomendaciones = new ArrayList<>();
        // portatil

        System.out.println("va entrar al switch de la eleccion de recomendaciones");

        data="Evita cargar la batería constantemente al 100%, ya que puede reducir su vida útil. Intenta mantenerla entre el 20% y el 80% de carga para prolongar su duración.";
        recomendaciones.add(new Recomendacion(1,data,1));

        data="Ajusta el brillo de la pantalla según las condiciones de iluminación para reducir el consumo de energía y prolongar la vida útil de la pantalla.";
        recomendaciones.add(new Recomendacion(2,data,2));

        data="Realiza actualizaciones regulares del sistema operativo para mantenerlo seguro y obtener las últimas características y mejoras de rendimiento.";
        recomendaciones.add(new Recomendacion(3,data,3));

        data="Verifica regularmente si hay actualizaciones de controladores disponibles para tu hardware y aplicarlas para garantizar un rendimiento óptimo y la compatibilidad del sistema.";
        recomendaciones.add(new Recomendacion(4,data,4));

        data="Desinstala programas y aplicaciones que no uses para liberar espacio en el disco duro y mejorar el rendimiento general del sistema.";
        recomendaciones.add(new Recomendacion(5,data,5));

        data="Instala y actualiza regularmente un software antivirus confiable para proteger tu sistema contra virus, malware y otras amenazas de seguridad en línea.";
        recomendaciones.add(new Recomendacion(6,data,6));

        data="Realiza pruebas de rendimiento periódicas para evaluar el rendimiento de tu sistema y detectar posibles problemas de hardware o cuellos de botella.";
        recomendaciones.add(new Recomendacion(7,data,7));

        data="Mantén un ojo en la temperatura del sistema y asegúrate de que no supere los niveles seguros durante el uso intensivo para evitar el sobrecalentamiento.";
        recomendaciones.add(new Recomendacion(8,data,8));

        data="Mantén limpias las lentes de las cámaras y los sensores para obtener imágenes nítidas y un rendimiento óptimo del sistema de detección.";
        recomendaciones.add(new Recomendacion(9,data,9));

        data="Limpia regularmente el teclado y el touchpad para evitar la acumulación de suciedad y mantener un funcionamiento suave y preciso.";
        recomendaciones.add(new Recomendacion(10,data,10));

        data="Verifica regularmente todas las conexiones externas, como cables y puertos, para asegurarte de que estén en buen estado y funcionen correctamente.";
        recomendaciones.add(new Recomendacion(11,data,11));

        data="Verifica que la cantidad de RAM instalada sea suficiente para ejecutar tus aplicaciones y tareas diarias sin problemas de rendimiento.";
        recomendaciones.add(new Recomendacion(12,data,12));

        data="Considera actualizar a un SSD si aún estás utilizando un disco duro tradicional, para mejorar significativamente el rendimiento y la velocidad de tu sistema.";
        recomendaciones.add(new Recomendacion(13,data,13));

        data="Comprueba que la GPU sea compatible con tus necesidades de trabajo o entretenimiento, especialmente si planeas ejecutar aplicaciones o juegos exigentes.";
        recomendaciones.add(new Recomendacion(14,data,14));

        data="Instalar ventiladores adicionales si es necesario para mantener una temperatura óptima en tu sistema y evitar el sobrecalentamiento de los componentes.";
        recomendaciones.add(new Recomendacion(15,data,15));

        data="Elige un monitor de alta calidad con una buena resolución y frecuencia de actualización para una experiencia visual óptima.";
        recomendaciones.add(new Recomendacion(16,data,16));

        data="Mantén tu sistema operativo actualizado para aprovechar las últimas características de seguridad y rendimiento.";
        recomendaciones.add(new Recomendacion(17,data,17));

        data="Actualiza regularmente los controladores de tus dispositivos para garantizar la compatibilidad y el rendimiento óptimo del hardware.";
        recomendaciones.add(new Recomendacion(18,data,18));

        data="Utiliza puertos USB de alta velocidad para dispositivos que requieran transferencias de datos rápidas, como unidades flash o discos duros externos.";
        recomendaciones.add(new Recomendacion(19,data,19));

        data="Realiza pruebas de rendimiento periódicas para evaluar el rendimiento de tu sistema y detectar posibles cuellos de botella o problemas de hardware.";
        recomendaciones.add(new Recomendacion(20,data,20));

        data="Mantén un ojo en la temperatura de tu sistema y asegúrate de que no supere los niveles seguros durante el uso intensivo.";
        recomendaciones.add(new Recomendacion(21,data,21));

        data="Mantén actualizados el software y los controladores de tu equipo para beneficiarte de las últimas características, correcciones de errores y mejoras de seguridad.";
        recomendaciones.add(new Recomendacion(22,data,22));

        //celular

        data= "Mantén el teléfono en una funda protectora y utiliza protectores de pantalla para evitar daños.";
        recomendaciones.add(new Recomendacion(23,data,23));

        data="Limpia regularmente la carcasa del teléfono con un paño suave y seco para eliminar el polvo y la suciedad.";
        recomendaciones.add(new Recomendacion(24,data,23));

        data="Evita exponer la pantalla a objetos afilados o a altas temperaturas para prevenir rayones y daños.";
        recomendaciones.add(new Recomendacion(25,data,24));

        data="Limpia la pantalla con un paño suave y sin pelusa para mantenerla libre de manchas y huellas dactilares.";
        recomendaciones.add(new Recomendacion(26,data,24));

        data="Evita presionar los botones con fuerza excesiva para evitar daños en los mecanismos internos.";
        recomendaciones.add(new Recomendacion(27,data,25));

        data="Limpia los puertos de carga y auriculares regularmente para eliminar el polvo y los residuos que puedan afectar la conectividad.";
        recomendaciones.add(new Recomendacion(28,data,25));

        data="Mantén las lentes de las cámaras limpias y sin rayones para obtener imágenes nítidas y claras.";
        recomendaciones.add(new Recomendacion(29,data,26));

        data="Evita exponer las cámaras a condiciones extremas de temperatura o humedad que puedan afectar su funcionamiento.";
        recomendaciones.add(new Recomendacion(30,data,26));

        data="Limpia los altavoces y el micrófono con aire comprimido o un cepillo suave para eliminar la suciedad y los residuos que puedan afectar la calidad del sonido.";
        recomendaciones.add(new Recomendacion(31,data,27));

        data="Evita exponer los altavoces y el micrófono a líquidos que puedan causar daños permanentes.";
        recomendaciones.add(new Recomendacion(32,data,27));

        data="Verifica regularmente el funcionamiento de los sensores y las funciones especiales del teléfono para asegurarte de que estén activos y funcionando correctamente.";
        recomendaciones.add(new Recomendacion(33,data,28));

        data="Si encuentras algún problema con los sensores o funciones especiales, reinicia el teléfono o consulta el servicio técnico para obtener ayuda.";
        recomendaciones.add(new Recomendacion(34,data,28));

        data="Evita exponer el teléfono a temperaturas extremadamente altas o bajas, ya que esto puede afectar la vida útil de la batería.";
        recomendaciones.add(new Recomendacion(35,data,29));

        data="Si notas que la batería se descarga más rápido de lo normal o se hincha, es posible que necesite ser reemplazada por una nueva.";
        recomendaciones.add(new Recomendacion(36,data,29));

        data="Mantén el sistema operativo y las aplicaciones del teléfono actualizadas para garantizar un rendimiento óptimo y la seguridad.";
        recomendaciones.add(new Recomendacion(37,data,30));

        data="Realiza regularmente copias de seguridad de tus datos importantes para evitar la pérdida de información en caso de problemas con el software.";
        recomendaciones.add(new Recomendacion(38,data,30));

        for (int i = 0; i < recomendaciones.size(); i++) {
            if (recomendaciones.get(i).getId_chek()==id){
                respuesta.add(recomendaciones.get(i));
            }
        }
        return respuesta;
    }




    // este metodo es para mostrar las recomendaciones al tecnico
    public List<String> traerRecomendacionesPorIdRevision(long idRevision) throws InterruptedException {
        List<String> respuesta = new ArrayList<>();
        Revision revision = new Revision();
        pedirRevisionAlProcesador(idRevision);
        Thread.sleep(1000);
        Revision revision1 = suscripcion1.getRevision();

        revision.setId(revision1.getId());
        revision.setFechaFinal(revision1.getFechaFinal());
        revision.setEquipo(revision1.getEquipo());
        revision.setObservacion(revision1.getObservacion());
        revision.setChekList(revision1.getChekList());

        for (int i = 0; i < revision.getChekList().size(); i++) {
            if (!revision.getChekList().get(i).isEstado()){
                for (int j = 0; j < revision.getChekList().get(i).getRecomendacionList().size(); j++) {
                    respuesta.add(revision.getChekList().get(i).getRecomendacionList().get(j).getRecomendacion());
                }
            }

        }
        return respuesta;
    }


    private void pedirRevisionAlProcesador(long id) {
        publicador.publicarColaC(id);
    }
}
