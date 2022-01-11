DO
$body$
BEGIN
    IF NOT EXISTS(
            SELECT *
            FROM pg_catalog.pg_user
            WHERE usename = 'mf')
    THEN
        CREATE ROLE mf WITH PASSWORD 'MF!2d7D2f3B';
    END IF;
END
$body$;

ALTER ROLE mf NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION LOGIN;
