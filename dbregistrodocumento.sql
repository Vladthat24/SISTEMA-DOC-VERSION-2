-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-11-2018 a las 05:00:20
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbregistrodocumento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

CREATE TABLE IF NOT EXISTS `acceso` (
  `idacceso` int(11) NOT NULL AUTO_INCREMENT,
  `idtrabajador` int(11) NOT NULL,
  `acceso` varchar(13) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`idacceso`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  KEY `fk_trabajador_acceso_idx` (`idtrabajador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `acceso`
--

INSERT INTO `acceso` (`idacceso`, `idtrabajador`, `acceso`, `login`, `password`, `estado`) VALUES
(1, 1, 'Administrador', 'admin', 'admin', 'A'),
(3, 2, 'Administrador', 'luciana', 'luciana', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistenciales`
--

CREATE TABLE IF NOT EXISTS `asistenciales` (
  `idasistenciales` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `cargo_institucion` varchar(100) NOT NULL,
  `modalidad_contrato` varchar(45) NOT NULL,
  `colegiatura` varchar(45) NOT NULL,
  `num_colegiatura` varchar(45) NOT NULL,
  `profesion` varchar(45) NOT NULL,
  `tipo_documento` varchar(30) NOT NULL,
  `num_documento` varchar(10) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idasistenciales`),
  UNIQUE KEY `num_documento_UNIQUE` (`num_documento`),
  UNIQUE KEY `num_colegiatura_UNIQUE` (`num_colegiatura`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `asistenciales`
--

INSERT INTO `asistenciales` (`idasistenciales`, `nombre`, `apellidos`, `cargo_institucion`, `modalidad_contrato`, `colegiatura`, `num_colegiatura`, `profesion`, `tipo_documento`, `num_documento`, `celular`, `fecha_registro`, `email`) VALUES
(1, 'MC. ITALO ', 'SANCHEZ CASTAÑEDA', 'JEFE DE LA MICRORED CMI DANIEL ALCIDES CARRION', 'NOMBREADO', 'CMP', '1111', 'Medico ', 'D.N.I.', '7624456', '121212121', '10/12/2017', 'PEDRO LAOS HURT'),
(2, 'GREASE GIANINA', 'IZQUIERDO LARICO', 'OBSTETRIZ', 'NOMRADA', 'COP', '01235', 'Obtetricia', 'D.N.I.', '1042568', '992605402', '23/8/2018', ''),
(3, 'DIANA IVONNE', 'FERRER PONCE ', 'MEDICO ASISTENCIAL ', 'NOMBRADA', 'CMP', '60212', 'Medico ', 'D.N.I.', '43566212', '931496291', '4 de Noviembre del 2018', 'DIANAFP@GMAIL.COM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado_salud`
--

CREATE TABLE IF NOT EXISTS `certificado_salud` (
  `idcertificado_salud` int(11) NOT NULL AUTO_INCREMENT,
  `idcerasistenciales` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `tipo_doc` varchar(45) NOT NULL,
  `num_doc` varchar(45) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `serelogia` varchar(45) NOT NULL,
  `examen_rx` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  PRIMARY KEY (`idcertificado_salud`),
  UNIQUE KEY `num_doc_UNIQUE` (`num_doc`),
  KEY `fk_asistenciales_certificado_salud_idx` (`idcerasistenciales`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `certificado_salud`
--

INSERT INTO `certificado_salud` (`idcertificado_salud`, `idcerasistenciales`, `nombre`, `apellidos`, `edad`, `tipo_doc`, `num_doc`, `direccion`, `serelogia`, `examen_rx`, `fecha_registro`) VALUES
(7, 1, 'MAGALY  MARIA', 'VALLEJOS LUNA', '20', 'DNI', '48485963', 'AV. LLOQUE YUPANQUI 542 MICAELA BASTIDAS', 'NO REACTIVO', 'NORMAL', '4 de Noviembre del 2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `constancia_nacimiento`
--

CREATE TABLE IF NOT EXISTS `constancia_nacimiento` (
  `idconstancia_nacimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idcasistenciales` int(11) NOT NULL,
  `correlativo_constancia` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipo_doc` varchar(45) NOT NULL,
  `num_doc` varchar(45) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `historia_clinica` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `peso` varchar(45) NOT NULL,
  `talla` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `hora_nacimiento` varchar(45) NOT NULL,
  `num_doc_nacido` varchar(45) NOT NULL,
  `fecha_nacimiento_letra` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `iniciales` varchar(45) NOT NULL,
  PRIMARY KEY (`idconstancia_nacimiento`),
  UNIQUE KEY `num_doc_UNIQUE` (`num_doc`),
  UNIQUE KEY `correlativo_constancia_UNIQUE` (`correlativo_constancia`),
  KEY `fk_asistenciales_constancia_nacimiento` (`idcasistenciales`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `constancia_nacimiento`
--

INSERT INTO `constancia_nacimiento` (`idconstancia_nacimiento`, `idcasistenciales`, `correlativo_constancia`, `nombre`, `apellidos`, `tipo_doc`, `num_doc`, `direccion`, `historia_clinica`, `sexo`, `peso`, `talla`, `fecha_nacimiento`, `hora_nacimiento`, `num_doc_nacido`, `fecha_nacimiento_letra`, `fecha_registro`, `iniciales`) VALUES
(1, 2, '001', 'JANET DORIS', 'GRABIEL', 'DNI', '40107371', 'CALLE LOS HERALDOS NEGROS N° 395 CESAR VALLEJO VILLA MARIA DEL TRIUNFO', '13362', 'Masculino', '3.660', '52', '1916-09-17', '20:42', '10045681', '16 de Junio del 2009', '18 de Septiembre del 2018', 'lmrg'),
(3, 2, '002', 'LUISA MARIA', 'LOPEZ MATOS', 'DNI', '15478932', 'MZ A LT 7 AH JOSE CARLOS MARIATEGUI SJM', '10152', 'Femenino', '3.400', '52', '1915-08-15', '10:15', '10031601', '15 de Mayo del 2007', '4 de Noviembre del 2018', 'MLCC/lmrg'),
(5, 2, '003', 'MARIA LUISA', 'GUTIERREZ LOAYZA', 'DNI', '12457832', 'MZ V LOTE 7 AH VILLA SOLIDARIDAD SJM', '12358', 'Masculino', '3.300', '54', '1913-12-08', '10:20', '10031601', '8 de null del 2004', '4 de Noviembre del 2018', 'MLCC/lmrg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe_medico`
--

CREATE TABLE IF NOT EXISTS `informe_medico` (
  `idinforme_medico` int(11) NOT NULL AUTO_INCREMENT,
  `idiasistenciales` int(11) NOT NULL,
  `correlativo_informemedico` varchar(45) NOT NULL,
  `nombre_paciente` varchar(45) NOT NULL,
  `apellidos_paciente` varchar(45) NOT NULL,
  `historia_clinica` varchar(45) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `tipo_documento` varchar(45) NOT NULL,
  `num_documento` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `diagnostico` varchar(100) NOT NULL,
  PRIMARY KEY (`idinforme_medico`),
  UNIQUE KEY `correlativo_informemedico_UNIQUE` (`correlativo_informemedico`),
  KEY `fk_asistenciales_informa_medico_idx` (`idiasistenciales`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `informe_medico`
--

INSERT INTO `informe_medico` (`idinforme_medico`, `idiasistenciales`, `correlativo_informemedico`, `nombre_paciente`, `apellidos_paciente`, `historia_clinica`, `direccion`, `sexo`, `edad`, `tipo_documento`, `num_documento`, `fecha_registro`, `diagnostico`) VALUES
(2, 1, '003', 'MARIANO', 'RIOA HUAMANLLANQUI', '101512', 'MZ V3 LT 3 3RA ETAPA DE VILLA SOLIDARIDAD SJM', 'Masculino', '45', 'DNI', '10151816', '18 de Septiembre del 2018', 'TBC PULMONAR'),
(3, 1, '004', 'DAVID MARIO', 'ALEJOS BARRIOS', '101514', 'CALLE CIRO ALEGRIA 342 ', 'Masculino', '30', 'DNI', '58472566', '4 de Noviembre del 2018', 'TBC PULMONAR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficio`
--

CREATE TABLE IF NOT EXISTS `oficio` (
  `idoficios` int(11) NOT NULL AUTO_INCREMENT,
  `idotrabajador` int(11) NOT NULL,
  `num_correlativo` varchar(4) NOT NULL,
  `receptor` varchar(45) NOT NULL,
  `cargo_receptor` varchar(100) NOT NULL,
  `atencion` varchar(100) NOT NULL,
  `asunto` varchar(256) NOT NULL,
  `cuerpo` varchar(1000) NOT NULL,
  `iniciales` varchar(18) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  PRIMARY KEY (`idoficios`),
  KEY `fk_trabajador_oficio_idx` (`idotrabajador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `oficio`
--

INSERT INTO `oficio` (`idoficios`, `idotrabajador`, `num_correlativo`, `receptor`, `cargo_receptor`, `atencion`, `asunto`, `cuerpo`, `iniciales`, `fecha`) VALUES
(4, 2, '001', 'M.C.ELADIO BENJAMIN PIMENTEL ROMAN ', 'DIRECTOR GENERAL - DIRIS LIMAR SUR', 'UNIDAD DE ODI DIRIS LIMA SUR', 'REMITO INFORME MENSUAL DEL CMI DANIEL ALCIDES CARRION', 'Es grato dirigirme a usted para saluadarlo muy cordialmente y la vez remitirle los informes  mensuales de los diferentes servicios  del CMI Daniel Alcides Carrion.\n\nSin otro en pàrticular, es propicia la oportunidad para expresar los sentimientos de mi consideracion y estima personal.\n\nAtentamente', 'MLCC/lmrg', '4 de Noviembre del 2018'),
(5, 2, '002', 'M.C.ELADIO BENJAMIN PIMENTEL ROMAN ', 'DIRECTOR GENERAL - DIRIS LIMAR SUR', 'UNIDAD DE LOGISTICA DIRIS LIMA SUR', 'REQUERIMIENTO DE INSUMOS MEDICOS PARA EL CMI DANIEL ALCIDES CARRION', 'Es grato dirigirme a usted para saludarlo muy cordialmente y a la vez, solicitarle insumos medicos que son muy necesarios para el area quirurgica sel servicio de Oftalmologia,  del CMI Daniel Alcides Carrion.\n\nSin otro en particular, es propicia la oportunidad`para expresar los sentimientos de consideracion y estima personal.\n\nAtentamente', 'MLCC/lmrg', '4 de Noviembre del 2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_trabajador`
--

CREATE TABLE IF NOT EXISTS `persona_trabajador` (
  `idptrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apaterno` varchar(25) NOT NULL,
  `amaterno` varchar(25) NOT NULL,
  `profesion` varchar(45) NOT NULL,
  `cargo_institucion` varchar(100) NOT NULL,
  `modalidad_contrato` varchar(45) NOT NULL,
  `tipo_documento` varchar(4) NOT NULL,
  PRIMARY KEY (`idptrabajador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `persona_trabajador`
--

INSERT INTO `persona_trabajador` (`idptrabajador`, `nombre`, `apaterno`, `amaterno`, `profesion`, `cargo_institucion`, `modalidad_contrato`, `tipo_documento`) VALUES
(1, 'LUIS', 'LUNA', 'PEREDA', 'ING', 'ADMINISTRATIVO', 'CAS', 'DNI'),
(2, 'LUZ MARIA', 'ROBLES', 'GUERRA', 'Técnico en Computación', 'Tecnico Administrativo', 'CAS', 'DNI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcion`
--

CREATE TABLE IF NOT EXISTS `recepcion` (
  `idrecepcion` int(11) NOT NULL AUTO_INCREMENT,
  `idtrabajador` int(11) NOT NULL,
  `correlativo` varchar(30) NOT NULL,
  `referencia` varchar(60) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `emisor` varchar(45) NOT NULL,
  `recepcionado` varchar(45) NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  PRIMARY KEY (`idrecepcion`),
  KEY `fk_trabajador_recepcion_idx` (`idtrabajador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `recepcion`
--

INSERT INTO `recepcion` (`idrecepcion`, `idtrabajador`, `correlativo`, `referencia`, `asunto`, `fecha`, `emisor`, `recepcionado`, `observaciones`) VALUES
(12, 2, '001', 'INFORME S/N', 'INFORME MENSUAL DEL SERVICIO DE LABORATORIO DICIEMBRE 2017', '15 de Septiembre del 2018', 'MC. JOSE LOAYZA AGUILAR', 'Recibido', ''),
(13, 2, '002', 'REPORTE S/N', 'REPORTE SEMANAL DE ATENCION DE PARTOS Y REFERENCIAS OBSTETRICAS', '15 de Septiembre del 2018', 'LIC MIRIAN LAURA CASTAÑEDA', 'Recibido', ''),
(14, 2, '003', 'OFICIO N° 528', 'SOLICITA TRATAMIENTO PSICOLOGICO', '18 de Septiembre del 2018', 'LIC CLAUDIA VANESSA', 'Recibido', ''),
(15, 1, '004', 'asdasd', 'asdasdasd', '4 de Noviembre del 2018', 'asdasd', 'Recibido', 'asdasdasdas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE IF NOT EXISTS `trabajador` (
  `idptrabajador` int(11) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fecha_registro` varchar(20) NOT NULL,
  PRIMARY KEY (`idptrabajador`),
  UNIQUE KEY `num_documento_UNIQUE` (`num_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idptrabajador`, `num_documento`, `celular`, `email`, `fecha_registro`) VALUES
(1, '76244566', '998805328', 'LUIS@HOTMAIL.COM', '5/12/2017'),
(2, '41915704', '947246490', 'lucimaria@hotmail.com', '23/8/2018');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD CONSTRAINT `fk_trabajador_acceso` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idptrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `certificado_salud`
--
ALTER TABLE `certificado_salud`
  ADD CONSTRAINT `fk_asistenciales_certificado_salud` FOREIGN KEY (`idcerasistenciales`) REFERENCES `asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `constancia_nacimiento`
--
ALTER TABLE `constancia_nacimiento`
  ADD CONSTRAINT `fk_asistenciales_constancia_nacimiento` FOREIGN KEY (`idcasistenciales`) REFERENCES `asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `informe_medico`
--
ALTER TABLE `informe_medico`
  ADD CONSTRAINT `fk_asistenciales_informa_medico` FOREIGN KEY (`idiasistenciales`) REFERENCES `asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `oficio`
--
ALTER TABLE `oficio`
  ADD CONSTRAINT `fk_trabajador_oficio` FOREIGN KEY (`idotrabajador`) REFERENCES `trabajador` (`idptrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD CONSTRAINT `fk_trabajador_recepcion` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idptrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `fk_persona_trabajador_trabajador` FOREIGN KEY (`idptrabajador`) REFERENCES `persona_trabajador` (`idptrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
