DESCRIPTION = "Hello World Recipe"
LICENSE = "CLOSED"

# inherit git

SRC_URI = "git://github.com/Gugfann/helloyocto.git;protocol=https;branch=main"
SRC_URI[sha256sum] = "a8f574d61d8239bd037ba051b336d0928734a955d371ec7965e600830c4d188f"

SRCREV = "${AUTOREV}"
# SRCREV = "47e9a4ebdb4085025755c15512fc6fe49652d0dd"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

do_compile() {
    bbnote "Source directory:"
    bbnote ${S}

    ${CXX} ${CXXFLAGS} ${LDFLAGS} src/main.cpp -o helloyocto
}

do_install() {
    bbnote "Destination directory:"
    bbnote ${D}${bindir}
    install -d ${D}${bindir}
    install -m 0755 helloyocto ${D}${bindir}
}

