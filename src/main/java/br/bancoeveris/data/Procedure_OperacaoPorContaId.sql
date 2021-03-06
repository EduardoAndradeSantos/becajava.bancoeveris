USE [Bancoeveris]
GO
/****** Object:  StoredProcedure [dbo].[SP_OperacoesPorConta]    Script Date: 16/11/2020 22:33:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE SP_OperacoesPorConta
    @idConta BIGINT

AS
BEGIN
    SELECT 
        id,
        tipo,
        valor,
        contaDestinoId,
        contaOrigemId
    FROM Operacao WHERE contaDestinoId = @idConta

    UNION
    SELECT 
        id,
        tipo,
        valor,
        contaDestinoId,
        contaOrigemId
    FROM Operacao WHERE contaOrigemId = @idConta

END