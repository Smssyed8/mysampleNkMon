#!/bin/bash

# JobPortal Database Installation Script
# ========================================
# PostgreSQL 9.4 on Linux/Mac

# Setup Instructions
# ------------------
#
# Open a terminal, then run the following commands:
#
# vi ~/.pgpass
#
# Add the following 2 lines to .pgpass (Without the first # on each line)
#    #hostname:port:database:username:password
#    localhost:5432:jobportal:mf:MF!2d7D2f3B
#
# Save and close .pgpass
#
# chmod 600 ~/.pgpass
#
# Close and re-open the terminal
#
# cd ~/repos/jobportal/database/shell-scripts
#
# ./create-database.sh
#


# Variables
# ------------------------------------------------------------------------------
server=localhost
database=jobportal
port=5432
dbuser=mf

OS=`uname -s`
SUDO=`which sudo`
PSQL=`which psql`
ADMIN_DB="postgres"
ADMIN_ROLE="postgres"

if [ "$OS" == "Darwin" ] ; then
    ADMIN_DB="template1"
    ADMIN_ROLE=`whoami`
fi

# Create the mf user role (use sudo)
# ------------------------------------------------------------------------------
echo "=== Creating role (user) ==="
$SUDO -u $ADMIN_ROLE $PSQL -d $ADMIN_DB < ../create-role.sql

# Drop and Create the DB as postgres (use sudo)
# ------------------------------------------------------------------------------
echo "=== Dropping old DB (if exists) ==="
$SUDO -u $ADMIN_ROLE $PSQL -d $ADMIN_DB < ../drop-database.sql
echo "=== Creating new DB ==="
$SUDO -u $ADMIN_ROLE $PSQL -d $ADMIN_DB < ../create-database.sql

# Create tables
# ------------------------------------------------------------------------------
echo "=== Creating tables ==="
echo "- country"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/country.sql
echo "- city"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/city.sql
echo "- account"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/account.sql
echo "- role"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/role.sql
echo "- account_role_map"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/account_role_map.sql
echo "- sector"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/sector.sql
echo "- job_role"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/job_role.sql
echo "- company_industry"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/company_industry.sql
echo "- job_type"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/job_type.sql
echo "- company_type"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/company_type.sql
echo "- job_level"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/job_level.sql
echo "- package"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/packages.sql
echo "- job_seeker"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/jobseeker.sql
echo "- employer"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/employer.sql
echo "- job"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/job.sql
echo "- jobseeker_job_map"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/jobseeker_job_map.sql
echo "- employer_jobseeker_map"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/employer_jobseeker_map.sql
echo "- education"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/education.sql
echo "- persistent_logins"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/persistent_logins.sql
echo "- spring_session"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/spring_session.sql
echo "- UserConnection"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/UserConnection.sql
echo "- web_contact_us"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/web_contact_us.sql
echo "- version"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/version.sql
echo "- advertisement"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/advertisement.sql
echo "- verification_token"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/verification_token.sql
echo "- orders"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/orders.sql
echo "- employer_contact_us"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../tables/employer_contact_us.sql

# Grant role permissions
# ------------------------------------------------------------------------------
echo "=== Granting role permissions ==="
$SUDO -u $ADMIN_ROLE $PSQL -d $database < ../grant-role-permissions.sql

# Default data
# ------------------------------------------------------------------------------

echo "=== Inserting default data ==="
echo "- country"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/country.sql
echo "- city"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/city.sql
echo "- account"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/account.sql
echo "- role"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/role.sql
echo "- account_role_map"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/account_role_map.sql
echo "- job_type"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/job_type.sql
echo "- job_role"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/job_role.sql
echo "- sector"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/sector.sql
echo "- company_industry"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/company_industry.sql
echo "- company_type"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/company_type.sql
echo "- job_level"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/job_level.sql
echo "- employer"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/employer.sql
echo "- jobseeker"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/jobseeker.sql
echo "- job"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/job.sql
echo "- packages"
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/packages.sql

# Update version
# ------------------------------------------------------------------------------

echo "=== Updating version ==="
$PSQL -h localhost -p 5432 -U mf -w -d $database  < ../data/version.sql
