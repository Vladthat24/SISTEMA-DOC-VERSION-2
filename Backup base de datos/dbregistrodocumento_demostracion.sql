-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2017 a las 06:45:31
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbregistrodocumento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

CREATE TABLE `acceso` (
  `idacceso` int(11) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `acceso` varchar(13) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `acceso`
--

INSERT INTO `acceso` (`idacceso`, `idtrabajador`, `acceso`, `login`, `password`, `estado`) VALUES
(1, 1, 'Administrador', 'admin', 'admin', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistenciales`
--

CREATE TABLE `asistenciales` (
  `idasistenciales` int(11) NOT NULL,
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
  `fecha_registro` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `asistenciales`
--

INSERT INTO `asistenciales` (`idasistenciales`, `nombre`, `apellidos`, `cargo_institucion`, `modalidad_contrato`, `colegiatura`, `num_colegiatura`, `profesion`, `tipo_documento`, `num_documento`, `celular`, `fecha_registro`, `email`) VALUES
(1, 'MC. ITALO ', 'SANCHEZ CASTAÑEDA', 'JEFE DE LA MICRORED CMI DANIEL ALCIDES CARRION', 'NOMBREADO', 'CMP', '1111', 'Medico ', 'D.N.I.', '7624456', '121212121', '10/12/2017', 'PEDRO LAOS HURT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado_salud`
--

CREATE TABLE `certificado_salud` (
  `idcertificado_salud` int(11) NOT NULL,
  `idcerasistenciales` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `tipo_doc` varchar(45) NOT NULL,
  `num_doc` varchar(45) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `serelogia` varchar(45) NOT NULL,
  `examen_rx` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `certificado_salud`
--

INSERT INTO `certificado_salud` (`idcertificado_salud`, `idcerasistenciales`, `nombre`, `apellidos`, `edad`, `tipo_doc`, `num_doc`, `direccion`, `serelogia`, `examen_rx`, `fecha_registro`) VALUES
(1, 1, 'YOSSHI', 'CONDORI MENDIETA', '23', 'DNI', '76244566', 'PEDRO LAOS HURTADO MZ 25 VALLE BAJO VALLE ALTO', 'NEGATIVO', 'NEGATIVO', '10 de Diciembre del 2017');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `constancia_nacimiento`
--

CREATE TABLE `constancia_nacimiento` (
  `idconstancia_nacimiento` int(11) NOT NULL,
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
  `iniciales` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `constancia_nacimiento`
--

INSERT INTO `constancia_nacimiento` (`idconstancia_nacimiento`, `idcasistenciales`, `correlativo_constancia`, `nombre`, `apellidos`, `tipo_doc`, `num_doc`, `direccion`, `historia_clinica`, `sexo`, `peso`, `talla`, `fecha_nacimiento`, `hora_nacimiento`, `num_doc_nacido`, `fecha_nacimiento_letra`, `fecha_registro`, `iniciales`) VALUES
(1, 1, '001', 'KARLA ROSMERY', 'LIMA CCORUPUNA', 'DNI', '76244566', 'PEDRO LAOS HURTADO MZ C LT 33 SJM VMT', '13012', 'Masculino', '30 gr.', '50 cm.', '1928-03-24', '11:45', '76244511', '27 de Diciembre del 2015', '10/12/2017', 'YC/yc'),
(2, 1, '002', 'asd', 'asd', 'DNI', '11111111', 'asdasdasd', '001', 'Masculino', 'asd', 'as', '1924-03-28', 'sdasd', '22222222', '', '10/12/2017', 'YC/yc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe_medico`
--

CREATE TABLE `informe_medico` (
  `idinforme_medico` int(11) NOT NULL,
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
  `diagnostico` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `informe_medico`
--

INSERT INTO `informe_medico` (`idinforme_medico`, `idiasistenciales`, `correlativo_informemedico`, `nombre_paciente`, `apellidos_paciente`, `historia_clinica`, `direccion`, `sexo`, `edad`, `tipo_documento`, `num_documento`, `fecha_registro`, `diagnostico`) VALUES
(1, 1, '001', 'YOSSHI SALVADOR ', 'CONDORI MENDIETA ', '121212', 'PEDRO LAOS HURTADO MZ C LT 33 BAJO VALLE ALTO VALLE', 'Masculino', '21', 'DNI', '7624456', '10 de Diciembre del 2017', 'TODO NORMAL CON EL PACIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficio`
--

CREATE TABLE `oficio` (
  `idoficios` int(11) NOT NULL,
  `idotrabajador` int(11) NOT NULL,
  `num_correlativo` varchar(4) NOT NULL,
  `receptor` varchar(45) NOT NULL,
  `cargo_receptor` varchar(100) NOT NULL,
  `atencion` varchar(100) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `cuerpo` varchar(1000) NOT NULL,
  `iniciales` varchar(10) NOT NULL,
  `fecha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `oficio`
--

INSERT INTO `oficio` (`idoficios`, `idotrabajador`, `num_correlativo`, `receptor`, `cargo_receptor`, `atencion`, `asunto`, `cuerpo`, `iniciales`, `fecha`) VALUES
(1, 1, '001', 'M.C.OLIVERA CARHUALLANQUI HUBERT', 'Medico Jefe de la Administracion de la DRS SJM-VMT', '123HRRASD', 'ASDASDASD12312', 'asdasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss', 'YC/yc', '10 de Diciembre del 2017');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_trabajador`
--

CREATE TABLE `persona_trabajador` (
  `idptrabajador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apaterno` varchar(25) NOT NULL,
  `amaterno` varchar(25) NOT NULL,
  `profesion` varchar(45) NOT NULL,
  `cargo_institucion` varchar(100) NOT NULL,
  `modalidad_contrato` varchar(45) NOT NULL,
  `tipo_documento` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_trabajador`
--

INSERT INTO `persona_trabajador` (`idptrabajador`, `nombre`, `apaterno`, `amaterno`, `profesion`, `cargo_institucion`, `modalidad_contrato`, `tipo_documento`) VALUES
(1, 'YOSSHI', 'CONDORI', 'MENDIETA', 'ING. SISTEMAS', 'SOPORTE INFORMATICO', 'CAS', 'DNI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcion`
--

CREATE TABLE `recepcion` (
  `idrecepcion` int(11) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `correlativo` varchar(30) NOT NULL,
  `referencia` varchar(60) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `emisor` varchar(45) NOT NULL,
  `recepcionado` varchar(45) NOT NULL,
  `observaciones` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recepcion`
--

INSERT INTO `recepcion` (`idrecepcion`, `idtrabajador`, `correlativo`, `referencia`, `asunto`, `fecha`, `emisor`, `recepcionado`, `observaciones`) VALUES
(1, 1, '003', 'RRHH - 03', 'PROBLEMAS CON LA DIGITACION MENSUAL DEL CENTRO', '16/12/2017', 'DIRECCION EJECUTIVA', 'Recibido', 'EL DOCUMENTO NO PRESENTA VISTO BUENO DE LA OFICINA DE ADMINISTRACION ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `idptrabajador` int(11) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fecha_registro` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idptrabajador`, `num_documento`, `celular`, `email`, `fecha_registro`) VALUES
(1, '76244566', '963734864', 'YOSSHI@HOTMAIL.COM', '5/12/2017');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD PRIMARY KEY (`idacceso`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`),
  ADD UNIQUE KEY `password_UNIQUE` (`password`),
  ADD KEY `fk_trabajador_acceso_idx` (`idtrabajador`);

--
-- Indices de la tabla `asistenciales`
--
ALTER TABLE `asistenciales`
  ADD PRIMARY KEY (`idasistenciales`),
  ADD UNIQUE KEY `num_documento_UNIQUE` (`num_documento`),
  ADD UNIQUE KEY `num_colegiatura_UNIQUE` (`num_colegiatura`);

--
-- Indices de la tabla `certificado_salud`
--
ALTER TABLE `certificado_salud`
  ADD PRIMARY KEY (`idcertificado_salud`),
  ADD UNIQUE KEY `num_doc_UNIQUE` (`num_doc`),
  ADD KEY `fk_asistenciales_certificado_salud_idx` (`idcerasistenciales`);

--
-- Indices de la tabla `constancia_nacimiento`
--
ALTER TABLE `constancia_nacimiento`
  ADD PRIMARY KEY (`idconstancia_nacimiento`),
  ADD UNIQUE KEY `num_doc_UNIQUE` (`num_doc`),
  ADD UNIQUE KEY `num_doc_nacido_UNIQUE` (`num_doc_nacido`),
  ADD UNIQUE KEY `correlativo_constancia_UNIQUE` (`correlativo_constancia`),
  ADD KEY `fk_asistenciales_constancia_nacimiento` (`idcasistenciales`);

--
-- Indices de la tabla `informe_medico`
--
ALTER TABLE `informe_medico`
  ADD PRIMARY KEY (`idinforme_medico`),
  ADD UNIQUE KEY `correlativo_informemedico_UNIQUE` (`correlativo_informemedico`),
  ADD KEY `fk_asistenciales_informa_medico_idx` (`idiasistenciales`);

--
-- Indices de la tabla `oficio`
--
ALTER TABLE `oficio`
  ADD PRIMARY KEY (`idoficios`),
  ADD KEY `fk_trabajador_oficio_idx` (`idotrabajador`);

--
-- Indices de la tabla `persona_trabajador`
--
ALTER TABLE `persona_trabajador`
  ADD PRIMARY KEY (`idptrabajador`);

--
-- Indices de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD PRIMARY KEY (`idrecepcion`),
  ADD KEY `fk_trabajador_recepcion_idx` (`idtrabajador`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`idptrabajador`),
  ADD UNIQUE KEY `num_documento_UNIQUE` (`num_documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acceso`
--
ALTER TABLE `acceso`
  MODIFY `idacceso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `asistenciales`
--
ALTER TABLE `asistenciales`
  MODIFY `idasistenciales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `certificado_salud`
--
ALTER TABLE `certificado_salud`
  MODIFY `idcertificado_salud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `constancia_nacimiento`
--
ALTER TABLE `constancia_nacimiento`
  MODIFY `idconstancia_nacimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `informe_medico`
--
ALTER TABLE `informe_medico`
  MODIFY `idinforme_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `oficio`
--
ALTER TABLE `oficio`
  MODIFY `idoficios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `persona_trabajador`
--
ALTER TABLE `persona_trabajador`
  MODIFY `idptrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  MODIFY `idrecepcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
