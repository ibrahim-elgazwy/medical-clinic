#!/bin/bash

psql -U $POSTGRES_USER -d $POSTGRES_DB -a -f /db/scripts/db/dump.sql