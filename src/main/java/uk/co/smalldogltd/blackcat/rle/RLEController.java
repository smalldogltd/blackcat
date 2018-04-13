package uk.co.smalldogltd.blackcat.rle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Spring Controller class to handle display and submission of form template - on submit to
 * the encode/decode endpoints, invokes the appropriate encode or decode and sets the encoded
 * and decoded text in the model object for display in the results page
 *
 * @author Paul Davis
 * @version 0.1
 */
@Controller
public class RLEController {

    @GetMapping("/bcencoder")
    public String encoderForm(Model model) {
        model.addAttribute("encodeText", new EncodeText());
        return "bcencoder";
    }

    @PostMapping("/bcencoder")
    public String encoderSubmit(@ModelAttribute EncodeText encodeText) {
        RunLengthEncoder encoder = new RunLengthEncoder();
        encodeText.setEncodedText(encoder.encode(encodeText.getDecodedText()));
        return "result";
    }

    @GetMapping("/bcdecoder")
    public String decoderForm(Model model) {
        model.addAttribute("encodeText", new EncodeText());
        return "bcencoder";
    }

    @PostMapping("/bcdecoder")
    public String decoderSubmit(@ModelAttribute EncodeText encodeText) {
        RunLengthDecoder decoder = new RunLengthDecoder();
        encodeText.setDecodedText(decoder.decode(encodeText.getEncodedText()));
        return "result";
    }


}
