USE [Bancoeveris]
GO

/****** Object:  Table [dbo].[Operacao]    Script Date: 16/11/2020 22:35:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Operacao](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](255) NULL,
	[valor] [float] NULL,
	[ContaDestinoId] [bigint] NULL,
	[ContaOrigemId] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Operacao]  WITH CHECK ADD  CONSTRAINT [FK1ius2w4x75hdtrne6bfknl9h2] FOREIGN KEY([ContaOrigemId])
REFERENCES [dbo].[Conta] ([id])
GO

ALTER TABLE [dbo].[Operacao] CHECK CONSTRAINT [FK1ius2w4x75hdtrne6bfknl9h2]
GO

ALTER TABLE [dbo].[Operacao]  WITH CHECK ADD  CONSTRAINT [FKqhrpwarwb8l57cvxcl759bbny] FOREIGN KEY([ContaDestinoId])
REFERENCES [dbo].[Conta] ([id])
GO

ALTER TABLE [dbo].[Operacao] CHECK CONSTRAINT [FKqhrpwarwb8l57cvxcl759bbny]
GO


