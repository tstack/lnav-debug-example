cmake_minimum_required(VERSION 3.14)

project(lnav-cpp-debug-example)

set(CMAKE_CXX_STANDARD 17)

# Add spdlog
include(FetchContent)
FetchContent_Declare(
  spdlog
  GIT_REPOSITORY https://github.com/gabime/spdlog.git
  GIT_TAG v1.13.0
)
FetchContent_MakeAvailable(spdlog)

add_executable(lnav-cpp-debug-example src/main.cpp src/helper.cpp)
target_link_libraries(lnav-cpp-debug-example PRIVATE spdlog::spdlog)
