job("Secrets and params") {
    container(image = "alpine") {
        env["SERVER"] = Params("server")
        env["SSHKEY"] = Secrets("stage.site.twnpx.ninja")
        shellScript {
            content = """
                echo My password for ${'$'}SERVER
            """
        }
    }
}