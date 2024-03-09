-> Imagine you have a configuration object for a web application, and you want to allow users to customize their preferences while keeping the default settings intact.

// Default configuration
const defaultConfig = {
  theme: 'light',
  fontSize: 16,
  language: 'en',
  showNotifications: true,
};

// User-specific preferences
const userPreferences = {
  theme: 'dark',
  fontSize: 18,
  showNotifications: false,
};

// Combine default configuration with user preferences
const mergedConfig = Object.assign({}, defaultConfig, userPreferences);

console.log('Merged Configuration:', mergedConfig);


Output:
Merged Configuration: {
  theme: 'dark',
  fontSize: 18,
  language: 'en',
  showNotifications: false
}

In this example:

defaultConfig represents the default settings for the web application.
userPreferences contains the user's customized preferences.
By using Object.assign({}, defaultConfig, userPreferences), we create a new object mergedConfig that combines the default configuration with the user preferences. This way, the user can customize specific settings while still inheriting the defaults for the ones they haven't changed.

