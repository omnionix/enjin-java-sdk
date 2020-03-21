package com.enjin.sdk.gen;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import io.freefair.gradle.codegenerator.api.Generator;
import io.freefair.gradle.codegenerator.api.ProjectContext;
import io.freefair.gradle.codegenerator.api.annotations.CodeGenerator;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@CodeGenerator
public class TemplateGenerator implements Generator {

    @Override
    public void generate(ProjectContext context) throws Exception {
        File resourcesDir = new File(context.getRootDir(), "src/main/resources");
        TemplateLoader templateLoader = new TemplateLoader(resourcesDir);

        templateLoader.load();

        generateTemplateClass(context, templateLoader);
    }

    private void generateTemplateClass(ProjectContext context, TemplateLoader templateLoader) {
        TypeSpec.Builder typeSpec = TypeSpec.classBuilder("TemplateConstants")
                                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

        for (Map.Entry<String, Template> entry : templateLoader.getOperations().entrySet()) {
            String fieldName = entry.getKey()
                                    .replace("Mutation", "")
                                    .replace("Query", "");
            String fieldValue = entry.getValue().compile().replace("\n", " ");
            FieldSpec spec = FieldSpec.builder(String.class,
                                               fieldName,
                                               Modifier.STATIC,
                                               Modifier.FINAL,
                                               Modifier.PUBLIC)
                                      .initializer("$S", fieldValue)
                                      .build();
            typeSpec.addField(spec);
        }

        JavaFile javaFile = JavaFile.builder("com.enjin.sdk.graphql", typeSpec.build())
                                    .build();

        try {
            javaFile.writeTo(context.getOutputDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
