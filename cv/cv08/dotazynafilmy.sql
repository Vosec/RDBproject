--1. 
SELECT nazev FROM Film WHERE reziser LIKE 'Steve%Spielberg' 
--2. 
SELECT DISTINCT X.rok, X.id_film FROM Film X, Hodnoceni Y WHERE X.id_film = Y.id_film AND (hodnoceni LIKE '4' OR hodnoceni LIKE '5') 
ORDER BY X.rok ASC 

SELECT DISTINCT rok FROM Film WHERE id_film in (SELECT id_film FROM Hodnoceni WHERE hodnoceni > 3) 
ORDER BY rok ASC 

--3. 
SELECT nazev FROM Film EXCEPT (SELECT DISTINCT nazev FROM Film X,Hodnoceni Y WHERE X.id_film = Y.id_film) 

SELECT nazev FROM Film WHERE id_film NOT IN (SELECT id_film FROM hodnoceni) 


SELECT nazev FROM Film 
( 
SELECT id_film FROM Film 
EXCEPT 
SELECT id_film FROM Hodnoceni 
) A 
WHERE Film.id_film = A.id_film 

--4. 
SELECT X.jmeno FROM Reviewer X, Hodnoceni Y WHERE X.id_reviewer = Y.id_reviewer AND Y.datum IS NULL 

SELECT jmeno FROM Reviewer WHERE id_reviewer IN (SELECT id_reviewer FROM Hodnoceni WHERE datum IS NULL) 

--5. 
SELECT R.jmeno, F.nazev, H.hodnoceni, H.datum FROM FILM F, Reviewer R, Hodnoceni H WHERE 
F.id_film = H.id_film AND R.id_reviewer = H.id_reviewer 
ORDER BY jmeno, nazev, hodnoceni 


--6. 

SELECT jmeno,nazev FROM Film, Reviewer,( 

SELECT H1.id_film, H1.id_reviewer FROM Hodnoceni H1, Hodnoceni H2 WHERE H1.id_reviewer = H2.id_reviewer AND H1.id_film = H2.id_film AND H1.datum < H2.datum AND H1.hodnoceni < H2.hodnoceni) H 
WHERE H.id_film = Film.id_film AND H.id_reviewer = Reviewer.id_reviewer 


--7. 
SELECT b.nazev, a.hodnoceni FROM ( 
SELECT id_film, MAX(hodnoceni) AS hodnoceni FROM Hodnoceni 
GROUP BY id_film 
) a JOIN Film b ON (a.id_film = b.id_film) 
ORDER BY b.nazev ASC 

SELECT nazev,MAX(hodnoceni) FROM Film,Hodnoceni 
WHERE Film.id_film = Hodnoceni.id_film 
GROUP BY nazev 
ORDER BY nazev ASC 


--8. 
SELECT nazev, rozsah FROM Film,( 
SELECT id_film, MAX(hodnoceni) - MIN(hodnoceni) AS rozsah FROM Hodnoceni 
GROUP BY id_film) R 
WHERE Film.id_film = R.id_film ORDER BY rozsah DESC 

--9. 
SELECT AVG(CONVERT(float,H1.prumer1)) - AVG(CONVERT(float,H2.prumer2)) AS prumer FROM 
(SELECT F.id_film, AVG(CONVERT( float,hodnoceni)) AS prumer1 FROM Film F, Hodnoceni WHERE F.id_film = Hodnoceni.id_film AND F.rok < 1980 GROUP BY F.id_film) H1, 
(SELECT F.id_film, AVG(CONVERT( float,hodnoceni)) AS prumer2 FROM Film F, Hodnoceni WHERE F.id_film = Hodnoceni.id_film AND F.rok >= 1980 GROUP BY F.id_film) H2 

--10. 
SELECT jmeno FROM Reviewer R JOIN Hodnoceni H ON (R.id_reviewer = H.id_reviewer) GROUP BY jmeno HAVING COUNT (*) >= 3 