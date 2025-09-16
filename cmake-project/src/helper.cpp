
#include <spdlog/spdlog.h>

void say_hello(const char* name) {
    spdlog::info("Hello, {}!", name);
}
