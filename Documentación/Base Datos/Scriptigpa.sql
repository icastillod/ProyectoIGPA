CREATE DATABASE igpa;

USE igpa;
------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE [dbo].[Materia](
	[IdMateria] [int] NOT NULL,
	[Materia] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Materia] PRIMARY KEY CLUSTERED 
(
	[IdMateria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

-------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[Pregunta](
	[IdPregunta] [int] NOT NULL,
	[Enunciado] [varchar](max) NOT NULL,
	[EstadoPregunta] [smallint] NOT NULL,
	[Complejidad] [smallint] NOT NULL,
	[IdTipoPregunta] [int] NOT NULL,
	[IdTema] [int] NOT NULL,
 CONSTRAINT [PK_Pregunta] PRIMARY KEY CLUSTERED 
(
	[IdPregunta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]


------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[Pregunta](
	[IdPregunta] [int] NOT NULL,
	[Enunciado] [varchar](max) NOT NULL,
	[EstadoPregunta] [smallint] NOT NULL,
	[Complejidad] [smallint] NOT NULL,
	[IdTipoPregunta] [int] NOT NULL,
	[IdTema] [int] NOT NULL,
 CONSTRAINT [PK_Pregunta] PRIMARY KEY CLUSTERED 
(
	[IdPregunta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]


ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_Tema] FOREIGN KEY([IdTema])
REFERENCES [dbo].[Tema] ([IdTema])
GO

ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_Tema]
GO

ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_TipoPregunta] FOREIGN KEY([IdTipoPregunta])
REFERENCES [dbo].[TipoPregunta] ([IdTipoPregunta])
GO

ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_TipoPregunta]
GO

ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_Tema] FOREIGN KEY([IdTema])
REFERENCES [dbo].[Tema] ([IdTema])
GO

ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_Tema]
GO

ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_TipoPregunta] FOREIGN KEY([IdTipoPregunta])
REFERENCES [dbo].[TipoPregunta] ([IdTipoPregunta])
GO
----------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[RepositorioExamenes](
	[IdExamen] [int] NOT NULL,
	[IdPregunta] [int] NOT NULL,
	[FechaGeneracion] [date] NOT NULL,
	[UsuarioGeneración] [int] NOT NULL,
 CONSTRAINT [PK_RepositorioExamenes] PRIMARY KEY CLUSTERED 
(
	[IdExamen] ASC,
	[IdPregunta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[RepositorioExamenes]  WITH CHECK ADD  CONSTRAINT [FK_RepositorioExamenes_Pregunta] FOREIGN KEY([IdPregunta])
REFERENCES [dbo].[Pregunta] ([IdPregunta])
GO

ALTER TABLE [dbo].[RepositorioExamenes] CHECK CONSTRAINT [FK_RepositorioExamenes_Pregunta]
GO

ALTER TABLE [dbo].[RepositorioExamenes]  WITH CHECK ADD  CONSTRAINT [FK_RepositorioExamenes_Usuario] FOREIGN KEY([UsuarioGeneración])
REFERENCES [dbo].[Usuario] ([Identificacion])
GO

ALTER TABLE [dbo].[RepositorioExamenes] CHECK CONSTRAINT [FK_RepositorioExamenes_Usuario]
GO


---------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[Respuesta](
	[IdRespuesta] [int] NOT NULL,
	[Respuesta] [varchar](max) NOT NULL,
	[ValorResultado] [smallint] NOT NULL,
	[EstadoRespuesta] [smallint] NOT NULL,
	[IdPregunta] [int] NOT NULL,
 CONSTRAINT [PK_Respuesta] PRIMARY KEY CLUSTERED 
(
	[IdRespuesta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Respuesta]  WITH CHECK ADD  CONSTRAINT [FK_Respuesta_Pregunta] FOREIGN KEY([IdPregunta])
REFERENCES [dbo].[Pregunta] ([IdPregunta])
GO

ALTER TABLE [dbo].[Respuesta] CHECK CONSTRAINT [FK_Respuesta_Pregunta]
GO

------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[Tema](
	[IdTema] [int] NOT NULL,
	[Tema] [varchar](50) NOT NULL,
	[IdMateria] [int] NOT NULL,
 CONSTRAINT [PK_Tema] PRIMARY KEY CLUSTERED 
(
	[IdTema] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Tema]  WITH CHECK ADD  CONSTRAINT [FK_Tema_Materia] FOREIGN KEY([IdMateria])
REFERENCES [dbo].[Materia] ([IdMateria])
GO

ALTER TABLE [dbo].[Tema] CHECK CONSTRAINT [FK_Tema_Materia]
GO

-------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[TipoPregunta](
	[IdTipoPregunta] [int] NOT NULL,
	[NombreTipoPregunta] [varchar](100) NOT NULL,
	[CantRespuestasPosibles] [int] NOT NULL,
	[CantRespuestasCorrectas] [int] NOT NULL,
 CONSTRAINT [PK_TipoPregunta] PRIMARY KEY CLUSTERED 
(
	[IdTipoPregunta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

--------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [dbo].[Usuario](
	[Identificacion] [int] NOT NULL,
	[Usuario] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[Identificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

-------------------------------------------------------------------------------------------------------------------------------------
ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_TipoPregunta]
GO


------------------------------------------------------------------------------------------------------------------

INSERT INTO [dbo].[Materia]([IdMateria],[Materia])
     VALUES (1,'Biologia')

INSERT INTO [dbo].[Materia]([IdMateria],[Materia])
     VALUES (2,'Matematicas')

INSERT INTO [dbo].[Materia]([IdMateria],[Materia])
     VALUES (3,'Sociales')

------------------------------------------------------------------------------------------------------------------

INSERT INTO [dbo].[TipoPregunta] ([IdTipoPregunta],[NombreTipoPregunta],[CantRespuestasPosibles],[CantRespuestasCorrectas])
     VALUES (1,'Selección multiple única respuesta',4,1)

INSERT INTO [dbo].[TipoPregunta] ([IdTipoPregunta],[NombreTipoPregunta],[CantRespuestasPosibles],[CantRespuestasCorrectas])
     VALUES (2,'Selección multiple única respuesta',4,2)

INSERT INTO [dbo].[TipoPregunta] ([IdTipoPregunta],[NombreTipoPregunta],[CantRespuestasPosibles],[CantRespuestasCorrectas])
     VALUES (3,'Selección multiple única respuesta',2,1)

------------------------------------------------------------------------------------------------------------------------

INSERT INTO [dbo].[Tema]([IdTema],[Tema],[IdMateria])
	VALUES (1,'Cuerpo humano',1)

INSERT INTO [dbo].[Tema]([IdTema],[Tema],[IdMateria])
	VALUES (2,'Las plantas',1)

INSERT INTO [dbo].[Tema]([IdTema],[Tema],[IdMateria])
	VALUES (3,'operaciones básicas',2)

INSERT INTO [dbo].[Tema]([IdTema],[Tema],[IdMateria])
	VALUES (4,'fracciones',2)

INSERT INTO [dbo].[Tema]([IdTema],[Tema],[IdMateria])
	VALUES (5,'moral',3)

-------------------------------------------------------------------------------------------------------

INSERT INTO [dbo].[Pregunta] ([IdPregunta], [Enunciado] ,[EstadoPregunta] ,[Complejidad], [IdTipoPregunta], [IdTema])
     VALUES (1,'Por medio de qué proceso las plantas adquieren su tonalidad verde',1 ,1, 2)

-------------------------------------------------------------------------------------------------------

INSERT INTO [dbo].[Respuesta]([IdRespuesta], [Respuesta], [ValorResultado], [EstadoRespuesta],[IdPregunta])
     VALUES (1,'fotosintesis',1,1,1)

INSERT INTO [dbo].[Respuesta]([IdRespuesta], [Respuesta], [ValorResultado], [EstadoRespuesta],[IdPregunta])
     VALUES (2,'mitosis',0,1,1)

INSERT INTO [dbo].[Respuesta]([IdRespuesta], [Respuesta], [ValorResultado], [EstadoRespuesta],[IdPregunta])
     VALUES (3,'simbiosis',0,1,1)

INSERT INTO [dbo].[Respuesta]([IdRespuesta], [Respuesta], [ValorResultado], [EstadoRespuesta],[IdPregunta])
     VALUES (4,'división molecuar',0,1,1)

