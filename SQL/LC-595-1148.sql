
// LC-595 Big Countries
SELECT name, population, area
FROM World
WHERE area >= 3000000
   OR population >= 25000000;
   
// LC-1148 Article Views I
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id ASC;