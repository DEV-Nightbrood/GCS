USE GCS;
GO
DELETE FROM individu WHERE nom IN ('Aliagagass','Bilgard','De la touque de Querqueville');
GO
INSERT INTO individu (nom,prenom) VALUES ('Aliagagass','Nicos'),('Bilgard','Jacques-Marie'),('De la touque de Querqueville','Rene-Lucien');