package mypackage.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=SlingHttpServletRequest.class)
public class DateFormatting {

  private static final Logger LOGGER = LoggerFactory.getLogger(DateFormatting.class);

  @Inject
  private Calendar date;

  @Inject
  private String dateFormat;

  public String formattedValue;

  @PostConstruct
  protected void init() {
    LOGGER.info("******INIT CALLED*********");  
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    formattedValue = formatter.format(date.getTime());
  }
}
