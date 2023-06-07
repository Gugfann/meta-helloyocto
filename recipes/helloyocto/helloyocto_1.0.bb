DESCRIPTION = "Hello World Recipe"
LICENSE = "CLOSED"

# inherit git

SRC_URI = "git://github.com/Gugfann/helloyocto.git;protocol=https;branch=main \
           file://0001-Made-a-patch-yo.patch \
           "
SRC_URI[sha256sum] = "a8f574d61d8239bd037ba051b336d0928734a955d371ec7965e600830c4d188f"

# SRCREV = "${AUTOREV}"
# Now that we have a patch, we need to be very specific about the git revision. AUTOREV will just take the latest commit
SRCREV = "8c738c51b47c43e782cf446cf674e909d285d6b"
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

