#!/bin/bash

PROJECT_NAME="$0"
PROJECT_FILE_NAME="$1"
BASE="src/main/java/com/ibostan/$PROJECT_NAME"
BASE_TEST="src/test/java/com/ibostan/$PROJECT_NAME"

project_folders=(
   "setup/scripts"
   "monitoring/splunk/alerts"
   "monitoring/splunk/dashboards"
   "$BASE"
   "$BASE_TEST"
)

app_folders=(
   "$BASE/application/configuration"
   "$BASE/application/properties"
   "$BASE/model/database/entities"
   "$BASE/model/database/repositories"
   "$BASE/model/mapper"
   "$BASE/model/enums"
   "$BASE/model/annotations"
   "$BASE/model/exceptions"
   "$BASE/model/exceptions/downstreams"
   "$BASE/domain/service"
   "$BASE/domain/service/aspects"
   "$BASE/domain/service/utils"
   "$BASE/domain/service/downstreams"
   "$BASE/domain/service/downstreams/interceptors"
   "$BASE/domain/service/downstreams/errorhandlers"
   "$BASE/domain/logging"
   "$BASE/domain/tracing"
   "$BASE/web/api"
   "$BASE/web/errorhandling"
   "$BASE/web/interceptors"
   "$BASE/web/filters"
)

db_migrations_folders=(
   "src/main/resources/db/migrations/common"
   "src/main/resources/db/migrations/environments"
   "src/main/resources/db/migrations/testdata"
)

create_folders() {
   for folder in "$@"; do
      mkdir -p "$folder"
   done
}

create_folders "${project_folders[@]}"
create_folders "${app_folders[@]}"
create_folders "${db_migrations_folders[@]}"

echo "Folder structure created."