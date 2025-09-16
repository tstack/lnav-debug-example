#include <unistd.h>
#include <iostream>
#include <spdlog/spdlog.h>

void say_hello(const char* name);

void do_error(int i, int j)
{
    spdlog::error("Oh noes: {} {}", i, j);
}

void do_multiline(const char* path)
{
    spdlog::warn("(This is a message\nthat spans multiple\nlines: {}", path);
}

int main(int argc, char* argv[]) {
    spdlog::info("This is a demo project for lnav's log debugging extension!");
    for (int i = 1; i < argc; ++i) {
        say_hello(argv[i]);
    }
    usleep(2500000);
    do_multiline(argv[0]);
    do_error(1, 2);
    spdlog::info("Goodbye!");
    return 0;
}
