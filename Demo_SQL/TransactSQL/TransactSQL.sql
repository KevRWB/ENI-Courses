-- TRANSACT SQL

select CONVERT(int, '1234');

select DATEDIFF(YEAR, '01/10/2000', GETDATE()); -- Différence entre 2 dates en années

select CONVERT(char, GETDATE(), 103); -- char = cible -> GetDate = date to convert    103 -> JJ/MM/AAAA

select CURRENT_TIMESTAMP;

select CONVERT(numeric(4,2), ROUND(  (100.0/3)  ,2 ))  ;

select CONVERT(char, DATEADD(DAY, 30, GETDATE()) ,103);

select SUBSTRING('SQL Server -SQL et Transact-SQL', CHARINDEX('Server', 'SQL Server -SQL et Transact-SQL'),  LEN('Server')  );

